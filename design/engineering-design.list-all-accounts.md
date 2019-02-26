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

Inside the method in controller POST request for a new account:

1. Call `AccountService.createAccount(account)`

2. `AccountService.createAccount(Account account)` calls to `AccountService.validate(account)` input method

3. `AccountService.validate(Account account)` evaluates the received fields in objects fill in the required criteria (maximum and minimum number of characters, not special characters, not blank fileds, etc). If this evaluation passes, this returns true, else returns false.

4. Once `AccountService.validate(Account account)` has returned , `AccountService.createAccount(Account account)` evaluates the returned value which is `boolean` and so if it's true this open a connection to database calling `AccountModel.save(account)`, while if it is false, so returns a JSON with a corresponding error message, for example:

   ```json
   {
       "errors": [
           {
               "property": "account",
               "message": "Maximum 20 charactes allowed"
           },
           {
               "property": "fullname",
               "message": "Maximum 255 charactes allowed"
           },
       ]
   }
   ```

   

3. `AccountModel.save(Account account)` open a MySQL connection to the `wallet` database (by calling a corresponding method  that open the connection if already isn't) and send the corresponding query `INSERT INTO ...` to the opened database. If query has been successful, it returns `true`.

4. As `AccountModel.save(account)` has return to `AccountService.createAccount(Account account)`, if value is true, so returns a JSON for successfully creation, for example for the first supposed created user:

   ```json
   {
       "id": 1,
       "account": "username",
       "fullname": "Full Name",
       "password": "password"
   }
   ```

   If false, this returns a JSON with exception message. For example:

   ```json
   {
       "error": "Error Establishing Database Connection"
   }
   ```



POJOS

```java
class AccountService {
    public createAccount(Account account) {
        if (validate(account)){
        	AccountModel.save(account);    
        }    	
    }
    
    public validate(Account account) {
        ans = new JsonAnswer();
        if (account.account == ""){
            jsonAnswer.add("account", "Field cannot be empty");            
        } else if (account.fullname == "" ) {
            jsonAnswer.add("account", "Field cannot be empty");
        } else if (account.password == "") {
            jsonAnswer.add("account", "Field cannot be empty");
        } ...
        
        if (jsonEmpty){
            return true;
        } else {
            return false
        }
    }    
}

class AccountModel {    
    public Boolean save(Account account) {
    	wallet = new dbConnector;
		ans = new JsonAnswer();

    	if (wallet.openConnection("MySQL") {
            if (wallet.query(query)) {
                return jsonAnswer.add(wallet.getID, wallet.getAccount, wallet.getFullname, wallet.getPassword);                                      
			} else {                                          
                return jsonAnswer.add(wallet.getError);
            }
            
    	}
    }
}

class dbConnector {
    public class<T> openConnection(String dbms){
        if (connection) {
            return jsonDbObject;
        } else {
            //throw exception
        }        
    }
}
        
class Account{
    String account;
    String fullname;
    String password;
}
```



- Validate the input
- Convert the request POJO into an entity to the database
- Store information to the database
- Be sure the `id` of the created entity is included back to the user

## Database

- Use MySQL

### Schema

#### Table: Account

| Column       | Type         | Key     | Nullable |
| ------------ | ------------ | ------- | -------- |
| id           | int(11)      | primary | No       |
| account_name | varchar(20)  |         | No       |
| fullname     | varchar(255) |         | No       |

**Indexes:** id