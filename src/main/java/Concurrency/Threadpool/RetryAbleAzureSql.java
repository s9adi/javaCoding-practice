package Concurrency.Threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class RetryAbleAzureSql {

    public static void main(String[] args) {

    }

    // write to Sql Azure might fail
    // try upto three times
    // think we can implement the Exceptions mechanisms here

    static CompletableFuture<Void> retryInsert(Transaction txn, Executor pool, int retry) {
        return CompletableFuture.runAsync(() -> {
            // insert to the SQL Db
            // if success it will return the Completable Future
            // if not then it should retry again
        }, pool).handle((res, ex) -> {
            if (ex == null) return CompletableFuture.completedFuture(null);
            if (retry > 0) {
                // retry again
                // call this function itself
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
               return  retryInsert(txn, pool, retry - 1);
            }
            else throw new CompletionException(ex);
        }).thenCompose(f -> (CompletableFuture<Void>)f);
    }

    static class Transaction {
        // Sample class
        // no code needed
    }
}

/*
Github Copilot


The selected code snippet, `}).thenCompose(f -> (CompletableFuture<Void>)f);`, is part of a chain of asynchronous operations using Java's `CompletableFuture`. It is used to flatten a nested `CompletableFuture` into a single `CompletableFuture<Void>`.

In the preceding logic, the `handle` method processes the result of an asynchronous task. If an exception occurs and retries are still allowed, the method recursively calls `retryInsert`, which returns a new `CompletableFuture`. This results in a nested structure of `CompletableFuture<CompletableFuture<Void>>`.

The `thenCompose` method is used here to resolve this nesting. The lambda expression `f -> (CompletableFuture<Void>)f` takes the nested `CompletableFuture` (`f`) and casts it to `CompletableFuture<Void>`. This effectively flattens the structure, ensuring that the final result is a single `CompletableFuture<Void>`.

This approach is necessary because `CompletableFuture` does not automatically flatten nested futures, and `thenCompose` is the idiomatic way in Java to handle such cases.


How does thenCompose flatten the map , Can youn explain ?
In Java's `CompletableFuture`, the `thenCompose` method is used to flatten a nested `CompletableFuture` into a single one. This is necessary when an asynchronous operation returns another `CompletableFuture` as its result, creating a nested structure like `CompletableFuture<CompletableFuture<T>>`.

### How it works:
1. **Nested Future**: When a `CompletableFuture` operation (e.g., `handle`) returns another `CompletableFuture`, the result is a nested structure. For example:
   ```java
   CompletableFuture<CompletableFuture<Void>> nestedFuture = CompletableFuture.completedFuture(
       CompletableFuture.completedFuture(null)
   );
   ```

2. **Flattening with thenCompose**: The `thenCompose` method takes a function that maps the result of the first `CompletableFuture` to another `CompletableFuture`. Instead of returning a nested future, it flattens the result into a single `CompletableFuture`. For example:
   ```java
   CompletableFuture<Void> flattenedFuture = nestedFuture.thenCompose(Function.identity());
   ```

3. **Why it works**: `thenCompose` internally waits for the first `CompletableFuture` to complete, retrieves the second `CompletableFuture`, and then returns it directly as the result. This avoids the need to manually handle the nested structure.

In your code:
```java
}).thenCompose(f -> (CompletableFuture<Void>)f);
```
The `thenCompose` call takes the nested `CompletableFuture<Void>` (`f`) returned by the `handle` method and flattens it into a single `CompletableFuture<Void>`. This ensures that the final result is not wrapped in multiple layers of `CompletableFuture`.

### How `thenCompose` Works in This Code:
In the `retryInsert` method, `thenCompose` is used to flatten a nested `CompletableFuture`. Here's how it works:

1. **Nested CompletableFuture**: The `handle` method in the code can return a `CompletableFuture<CompletableFuture<Void>>` because, in case of a retry, it recursively calls `retryInsert`, which itself returns a `CompletableFuture`.

2. **Flattening**: `thenCompose` takes the nested `CompletableFuture` returned by `handle` and flattens it into a single `CompletableFuture<Void>`. This is achieved by:
   ```java
   }).thenCompose(f -> (CompletableFuture<Void>) f);
   ```
   Here, `f` is the nested `CompletableFuture`. `thenCompose` ensures that the outer `CompletableFuture` resolves only when the inner one completes, effectively flattening the structure.

3. **Why It's Needed**: Without `thenCompose`, you would end up with a nested future (`CompletableFuture<CompletableFuture<Void>>`), which is harder to work with. `thenCompose` simplifies this by chaining the futures.

---

### Does `handle` Always Return a `CompletableFuture`?
No, the `handle` method does **not always return a `CompletableFuture`**. It depends on the logic inside the `handle` block.

- In this case, `handle` returns a `CompletableFuture` because:
  - On success (`ex == null`), it explicitly returns `CompletableFuture.completedFuture(null)`.
  - On failure with retries left, it recursively calls `retryInsert`, which also returns a `CompletableFuture`.

- In general, `handle` can return any type (`U`) based on the provided logic. It does not inherently return a `CompletableFuture` unless explicitly coded to do so, as in this case.


Will the Nested CompletableFuture Be Three Times Nested After Retries?
No, the nested CompletableFuture will not be three times nested after all retries. This is because thenCompose is used to flatten the structure at each step.

For example:


On the first retry, retryInsert returns a CompletableFuture<Void>.
If a second retry is needed, the handle method returns a new CompletableFuture<Void>, but thenCompose flattens it into a single CompletableFuture<Void>.
This process repeats for the third retry, but the result is always a single CompletableFuture<Void> due to thenCompose.
Without thenCompose, the structure would indeed become nested (CompletableFuture<CompletableFuture<...>>), but thenCompose ensures that the result remains flat.
 */
