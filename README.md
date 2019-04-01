# Wallet Application 


## Running the database

Database is provisioned using `docker-compose`. For that, following steps must be accomplished:

1. Set wallet's database password by creating following environmental variable

   ```bash
   $ export MYSQL_PASSWD=<password>
   ```

   

2. Set MySQL's root password by creating following environmental variable

   ```bash
   $ export MYSQL_ROOT_PASSWD=<password>
   ```

   

3. Deploy

   ```bash
   $ docker-compose -f docker-compose.yml up
   ```

   

## Database connectivity - CLI

### From host

In order to test database connectivity from host, we need to use `mysql-client`, and run following command:

```bash
$ mysql -h 127.0.0.1 -u wallet -p wallet
```

- `-h` means host to connect, notice that we use localhost IP address instead to use `localhost` , this is to avoid the use of host [sockets](https://serverfault.com/a/306423) and consequent `ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/run/mysqld/mysqld.sock' (2)`, and instead of that to use local MySQL port that was enabled from provisioning.
- `-u` specifies the user to connect with.
- `-p` means that a password needs to be provided.
- Finally we specify the database to connect, in this case  `wallet`.



System will ask the password which we specified in `$MYSQL_PASSWD` environment variable.



### From inside container

We can also connect to database from inside the container, but for that, we need first to access the container self.

Following command will show container's information:

```bash
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
1c109035d7e1        mariadb             "docker-entrypoint.s…"   55 seconds ago      Up 53 seconds       0.0.0.0:3306->3306/tcp   provision_db_1
```



We use container's name (which in this case is `provision_db_1`) to establish connection:

```bash
$ docker exec -it provision_db_1 bash
```



And run corresponding connection command:

```bash
root@1c109035d7e1:/# mysql -u wallet       
```



**NOTE:** Same instructions apply to access using MySQL root user and password specified in `$MYSQL_ROOT_PASSWD` environment variable.
