# Engineering Design

## Architecture

**TODO:**: Draw a diagram

- Will be written in Java.
- Will be written using Spring Framework (Spring web and Spring Boot).

## HTTP endpoints

### List accounts

Inside the method in controller GET request for list accounts:

1. Call `AccountService.listAccounts()`
1. `AccountService.listAccounts()` returns a list of accounts entries from the database.
   1. If there is not any entry, then return a empty list.
   1. Always return first 20 entries.
   1. Service must handle database exceptions.

POJOS

```java
class ListAccountsResponse {
    List data = new ArrayList<AccountEntry>;
}

class AccountEntry {
    String account;
    String fullname;
}
```

### New account

**TODO:** Work in this

- Validate the input
- Convert the request POJO into an entity to the database
- Store information to the database
- Be sure the `id` of the created entity is included back to the user

## Database

- Use MySQL

### Schema

#### Table: Account

| Column   | Type     | Key     |  Nullable  |
| -------- |:--------:|:-------:|:----------:|
| id       | int(11)  | primary |    No
| account_name | varchar(20)  |  |  No |
| fullname | varchar(255)  |  | No  |

**Indexes:** id