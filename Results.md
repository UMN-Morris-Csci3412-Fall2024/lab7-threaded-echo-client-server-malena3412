# Stress Testing Results

## Machine Specifications
- **CPU:** 11th Gen Intel(R) Core(TM) i5-11600 @ 2.80GHz
- **Number of Cores:** 12
- **RAM:** 14 GB
- **Operating System:** Rocky Linux 9.4 (Blue Onyx)

## Test Setup
- **Number of Clients:** 5 and 10
- **File Size:** 100MB
- **Server Modes Tested:**
  - Single-threaded
  - Multi-threaded with Thread Pool

## Observations

### Single-threaded Mode
- **Execution Time:**
  - 5 Clients: 4 minutes
  - 10 Clients: 6 minutes
- **Observations:**
  - The server struggled to handle multiple clients concurrently.
  - Increased latency as the number of clients increased.

### Multi-threaded Mode with Thread Pool
- **Execution Time:**
  - 5 Clients: 4 minutes
  - 10 Clients: 6 minutes
- **Observations:**
  - The server handled multiple clients with a similar efficiency to single-threaded.

## Summary
- **Comparison of Single-threaded and Multi-threaded Performance:**
  - The multi-threaded approach with a thread pool did not really differ from the single-threaded approach.
  - Not really sure why there was no difference in this case but it could have something to do with memory or the I/O operations.

- **Impact of Increasing the Number of Clients:**
  - In both modes, increasing the number of clients led to increases in execution time.