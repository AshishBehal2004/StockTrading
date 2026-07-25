# GameStonk Share Trading
<p align="center">
  <img width="500" height="220" alt="Screenshot 2026-07-25 at 2 52 53 pm"  src="https://github.com/user-attachments/assets/1a871435-33ee-47f7-b531-561a6c294da5" />
</p>

A simplified stock exchange simulation in Java, built around the same conflict of interest that got Robinhood in trouble during the 2021 GameStop short squeeze: brokers are supposed to process trades first-in, first-out, but the priority queue lets a broker's own watchlisted stocks jump the line.

## What it does

- **SecuritiesExchange** holds a set of `ListedCompany` objects and `StockBroker`s, and processes trades round by round.
- **StockBroker** queues incoming trades in a `PriorityQueue<Trade>`, ordered so trades touching the broker's watchlist get priority over the rest, modeling the real-world "queue jumping" conflict of interest.
- **Trade** links a broker, a company code, and a share quantity, and implements `Comparable` to drive that priority ordering.
- **ListedCompany** adjusts its own share price on every trade, up for buys, down for sells.
- **UntradedCompanyException** is thrown if a trade references a company that isn't listed on the exchange.
- The whole thing runs on a **custom doubly-linked list** (`DSEList`), later generified into `DSEListGeneric<T>` — no `java.util.LinkedList`, built from scratch.

## Tech

Java, JUnit for testing.

## Project structure

```
src/unisa/dse/a2/
  interfaces/   — List/ListGeneric interfaces
  students/     — DSEList, DSEListGeneric, ListedCompany, StockBroker, Trade,
                   SecuritiesExchange, UntradedCompanyException
  junit/        — unit tests for each class
  marking/      — Driver.java (a runnable demo) and the auto-marker
```

## Running it

`Driver.java` sets up a small exchange ("ASX") with two brokers, Honest Harry Broking and Dodge Dave Broking, trading fictional companies (including, fittingly, one called GameStonk) and processes a round of trades between them.

Unit tests for each class live under `junit/` and can be run individually in Eclipse, or all together via `AssignmentMarker.java`.
