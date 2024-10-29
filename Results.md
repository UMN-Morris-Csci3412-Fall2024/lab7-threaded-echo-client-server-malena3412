# Stress Testing Results

## Machine Specifications
- **CPU:** 11th Gen Intel(R) Core(TM) i5-11600 @ 2.80GHz
- **Number of Cores:** 12
- **RAM:** 14 GB
- **Operating System:** Rocky Linux 9.4 (Blue Onyx)

## Test Setup
- **Number of Clients:** [Number of clients used, e.g., 10, 20, 50]
- **File Size:** [Size of the file used, e.g., 100MB]
- **Server Modes Tested:**
  - Single-threaded
  - Multi-threaded with Thread Pool

## Observations

### Single-threaded Mode
- **Execution Time:**
  - 5 Clients: [Time taken, e.g., 30 seconds]
  - 10 Clients: [Time taken, e.g., 60 seconds]
- **CPU Usage:**
  - Observed high CPU usage on a single core.
- **Memory Usage:**
  - [Memory usage details, e.g., 500MB]
- **Observations:**
  - The server struggled to handle multiple clients concurrently.
  - Increased latency as the number of clients increased.
  - Single core was heavily utilized, leading to potential bottlenecks.

### Multi-threaded Mode with Thread Pool
- **Execution Time:**
  - 10 Clients: [Time taken, e.g., 15 seconds]
  - 20 Clients: [Time taken, e.g., 25 seconds]
  - 50 Clients: [Time taken, e.g., 60 seconds]
- **CPU Usage:**
  - Utilized multiple cores effectively.
  - Lower CPU usage per core compared to single-threaded mode.
- **Memory Usage:**
  - [Memory usage details, e.g., 700MB]
- **Observations:**
  - The server handled multiple clients more efficiently.
  - Reduced latency and better performance under load.
  - Effective distribution of tasks across multiple cores.

## Summary
- **Comparison of Single-threaded and Multi-threaded Performance:**
  - The multi-threaded approach with a thread pool significantly outperformed the single-threaded approach.
  - The single-threaded server experienced high latency and CPU bottlenecks as the number of clients increased.
  - The multi-threaded server utilized multiple cores, leading to better performance and lower latency.

- **Impact of Increasing the Number of Clients:**
  - In the single-threaded mode, increasing the number of clients led to exponential increases in execution time and CPU usage.
  - In the multi-threaded mode, the server scaled better with the number of clients, showing more linear increases in execution time.

- **Other Observations:**
  - The choice of file size and number of clients significantly impacts server performance.
  - Monitoring tools like `htop` were useful in observing CPU and memory usage in real-time.

By following these steps and documenting your observations, you can provide a comprehensive summary of your stress testing results.