# Streams and Pipelines

## Streams:
- Streams is a sequence of elements that comes from a source of data that offers support to assembled operations;
  - Source of data: collections, array, iteration;
  - HashCode: fast but the answer might not be always true;
  - For further reading: https://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html

## Characteristics:
- Stream is a solution to process data sequel;
  - Declarative(internal iteration: hidden from the programmer);
  - Parallel-friendly: immutable -> thread safe;
  - Without side effects;
  - Lazy Evaluation;

- Sequential access(no index);
- Single use;


## Pipeline:
- Streams operations return new streams. So, it is possible to create a chain of operations(processing flow);
  
- Intermediary operation:
  - Generates a new stream(chain);
  - Only performs when a new terminal operation is called on(lazy evaluation);
  - Operations:
    - filter()
    - map()
    - flatmap()
    - peek()
    - distinct()
    - sorted()
    - skip()
    - limit() - short-circuit

- Terminal operation:
  - Generates a non-stream object(collection or other);
  - Determinates the end of the stream process;
  - Operations:
    - forEach()
    - forEachOrdered()
    - toArray()
    - reduce()
    - collect()
    - min()
    - max()
    - count()
    - anyMatch() - short-circuit
    - allMatch() - short-circuit
    - noneMatch() - short-circuit
    - findFirst() - short-circuit
    - findAny() - short-circuit

  
  **-----------------------------------------------------------------------------------**
  
  
  **Remember that i'm in learning process, i'm open for constructive criticism and tips, please, feel free to help, Thanks!**
