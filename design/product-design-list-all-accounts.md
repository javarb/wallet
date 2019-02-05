# LIST AND CREATE ACCOUNTS

## List accounts

Shows all accounts in system, has a button that allows to go to the account creation view.
The name of each acount can be clicked and this will lead to a blank page (for the moment)

## Create account

Shows a form to enter the account information:

- Account name: Must be unique among all other names on the system.
- Person fullname: should be minimum 1 character long or maximun 255 characters.

Finally when we press submit button, if the content provided in the form is valid, this will redirect to list accounts page, else will show an feedback error message showing form mistakes.

## Wireframes

Images (mocks)

- List accounts page
- Forms page
- Forms page error

## API contract

### List accounts page

| RES API spec  | content       |
| ------------- |:-------------:|
| Request headers     | Content-Type: application/json |
| Request HTTP method | GET      |
| Request URL       | /account/list      |
| Request body       | ---      |
| Response headers       | Content-Type: application/json     |
| Response body       | {"data": [{account: "username1", "fullname": "User Name 1",...}]      |
| Response status code       | 200     |

### Forms page

#### Showing form

| RES API spec  | content       |
| ------------- |:-------------:|
| Request headers     | Content-Type: text/html; charset=utf-8 |
| Request HTTP method | GET      |
| Request URL       | /account/new      |
| Request body       | ---      |
| Response headers    | Content-Type: text/html; charset=utf-8     |
| Response body       | `<html>...</html>`      |
| Response status code       | 200     |

#### Sending form

| RES API spec  | content       |
| ------------- |:-------------:|
| Request headers     | Content-Type: multipart/form-data |
| Request HTTP method | POST      |
| Request URL       | /account/new      |
| Request body       | `POST /account/new HTTP/1.1 ...`      |
| Response headers    | Content-Type: text/html; charset=utf-8      |
| Response body       | `<html>...</html>`      |
| Response status code       | 200     |

### Forms page error

| RES API spec  | content       |
| ------------- |:-------------:|
| Request headers     | Content-Type: multipart/form-data |
| Request HTTP method | POST      |
| Request URL       | /account/new      |
| Request body       | `POST /account/new HTTP/1.1 ...`      |
| Response headers    | Content-Type: text/html; charset=utf-8      |
| Response body       | `<html>...</html>`      |
| Response status code       | 400     |
