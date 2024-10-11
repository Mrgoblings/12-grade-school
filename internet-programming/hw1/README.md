## How to Run the Server and Client
0. Go to the `hw1` folder
```sh
cd internet-programming/hw1
```

### Running the Server
1. Open a new terminal window.
2. Compile with javac (necessary because code is split into multiple files)
```sh
javac server/*.java
```
3. Run the server:
```sh
java server/Server.java
```

### Running the Client
1. Open a new terminal window.
2. Run the client:
```sh
java client/Client.java
```

### Notes
- The server reads and writes data to the `server/students.txt` file.
- Ensure the server is running before starting the client.
- Follow the instructions written to the console output.