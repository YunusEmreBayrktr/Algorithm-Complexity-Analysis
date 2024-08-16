For testing the code on Linux-based systems the following commands can be used:

Compilation:
javac -cp *.jar *.java -d .
Execution:
java -cp .:* Main TrafficFlowDataset.csv

For testing the code on Windows systems (Powershell) the following commands can be used:

Compilation:
javac -cp *.jar *.java -d .
Execution:
java -cp '.;*' Main .\TrafficFlowDataset.csv

For testing the code on Windows systems (cmd) the following commands can be used:

Compilation:
javac -cp *.jar *.java -d .
Execution:
java -cp .;* Main .\TrafficFlowDataset.csv
