# 360T-Test
# Player Communication APP

## Description
This Player Communication APP allows for simple message passing between a server and client in a gaming context. The system comes in two versions: a single-processed version for basic message exchange and a multi-processed version for handling double-side simultaneously.


## Prerequisites
- Java JDK 17 or higher
- Maven


## Running the Application

### Running the Single-Processed Version

To run the single-threaded version of the application, navigate to the root directory of the project and run:

```bash
sh startSingleProcess.sh
```
### Running the double-Processed Version
The multi-threaded version requires starting the server before any clients. Run the following scripts in order:

1. Start the server: Navigate to the root directory and run:

```bash
sh startPlayer2_Server.sh
```
Ensure the server is ready to accept connections before proceeding to the next step.

2. Start the client: Open a new terminal window, navigate to the root directory and run:

```bash
sh startPlayer1_Client.sh
```