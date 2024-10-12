# codetotrade-java-client

This is the codetotrade.app Java client.

## Overview

This project is a Java client for interacting with the codetotrade.app platform. It includes a example trading bot that uses the MACD and RSI indicators to make buy and sell decisions.

## Features

- **Back Test**: Includes a back testing server to test trading strategies.
- **Real Trade**: Includes a real trading server to execute trades on the supported exchange.

## Supported Exchanges
- Binance
- ... (more exchanges will be added in the future)

## Requirements

- Java 21 or higher
- Maven

## Quick start
```
<dependency>
    <groupId>io.github.truongnhukhang</groupId>
    <artifactId>codetotrade-java-client</artifactId>
    <version>1.0</version>
</dependency>
```
Run `mvn install` where `pom.xml` is located to install the dependency.

## Usage

### Create your own trading bot

####  Implement the `BaseBot` interface

```java
public class TestBot extends BaseBot {
    @Override
    public void init(Map<String, String> params) {
    }

    @Override
    public boolean isBuy(int index) {
        return false;
    }

    @Override
    public boolean isSell(int index) {
        return false;
    }

    @Override
    public boolean isCloseCurrentPosition(int index) {
        return super.isCloseCurrentPosition(index);
    }

    @Override
    public TradeMetadata buy(int index) {
        return null;
    }

    @Override
    public TradeMetadata sell(int index) {
        return null;
    }
}
```
### Run back test server for your trading bot

```java
public class TestBot extends BaseBot {
    public static void main(String[] args) {
        BackTestServer backTestServer = new BackTestServer(new TestBot());
        server.start();
        server.blockUntilShutdown();;
    }
}
```

### Connect to exchange and run your trading bot

#### Binance Exchange
```java
public class TestBot extends BaseBot {
    public static void main(String[] args) {
        BinanceServer binanceServer = new BinanceServer("apikey", "secretkey", true, 8088, MacdRsiBot.class);
        binanceServer.start();
        binanceServer.blockUntilShutdown();
    }
}
```
