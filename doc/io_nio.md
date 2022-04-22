- 阻塞IO（BIO，Blocking IO）：线程会挂起，等待IO资源到位后OS通知
- 非阻塞IO（NIO，Non-Blocking IO）：线程会一直询问IO资源是否到位
- 同步IO是调用方通过主动等待获取调用返回的结果
- 异步IO是被调用方通过某种方式（如回调函数）来通知调用方


An example:
```text
Module X: "I".
Module Y: "bookstore".
X asks Y: do you have a book named "c++ primer"?

blocking: before Y answers X, X keeps waiting there for the answer. Now X (one module) is blocking. X and Y are two threads or two processes or one thread or one process? we DON'T know.

non-blocking: before Y answers X, X just leaves there and do other things. X may come back every two minutes to check if Y has finished its job? Or X won't come back until Y calls him? We don't know. We only know that X can do other things before Y finishes its job. Here X (one module) is non-blocking. X and Y are two threads or two processes or one process? we DON'T know. BUT we are sure that X and Y couldn't be one thread.

synchronous: before Y answers X, X keeps waiting there for the answer. It means that X can't continue until Y finishes its job. Now we say: X and Y (two modules) are synchronous. X and Y are two threads or two processes or one thread or one process? we DON'T know.

asynchronous: before Y answers X, X leaves there and X can do other jobs. X won't come back until Y calls him. Now we say: X and Y (two modules) are asynchronous. X and Y are two threads or two processes or one process? we DON'T know. BUT we are sure that X and Y couldn't be one thread.
```