# MyMoney Solution

## Author Info
Name: Muhammad Bilal Khan

Email: m.bilal.iqbal.98@gmail.com

## Problem Statement
‘MyMoney’ is a platform that lets investors track their consolidated portfolio value across equity, debt, and gold.

Rebalance the portfolio to reduce the gains from one asset class and investing them in another, to ensure that the desired weight for each asset class doesn't deviate because of market gains/losses.

## Solution
For the given problem of managing a portfolio and performing actions like allocation, rebalancing, and generating output, the most suitable design pattern would be the Command Pattern.

In the context of the portfolio management problem, the Command Pattern is used as follows:

* A Command interface that declares a method execute().
* Concrete command classes that implement the Command interface, representing each action or operation in the portfolio management system (e.g., AllocateCommand, SipCommand, ChangeCommand, BalanceCommand, RebalanceCommand).
* In the PortfolioManager, a collection of commands is maintained and executed them based on the file instructions.
* The PortfolioManager acts as the invoker, receiving user commands and executing the corresponding command objects.
* Each command object encapsulates the logic to perform its specific operation, modifying the portfolio or generating output as required.
* By applying the Command Pattern, a more flexible and extensible design is achieved. It allows for easy addition of new commands in the future, supports undo/redo functionality if required, and provides a clean separation of responsibilities between the invoker and the command objects.

## Pre-requisites
* Java 1.8/1.11/1.15
* Maven

## How to run the code

Scripts are provided to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.

Internally both the scripts run the following commands 

 * `mvn clean install -DskipTests assembly:single -q` - This will create a jar file `geektrust.jar` in the `target` folder.
 * `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

Although, all the input files should be moved from `sample_input` to `resources` folder but they are duplicated in both locations for now as commands in `run.sh` and `run.bat` are referencing to `sample_input` folder.

## How to execute the unit tests

 `mvn clean test` will execute the unit test cases.
