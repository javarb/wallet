# Wallet Application 

## Running the database

Database is provisioned using `docker-compose`. For that, we need [`docker`](https://docs.docker.com/install/) and [`docker-compose`](https://docs.docker.com/compose/install/) installed on our host.

Following steps must be accomplished:

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

We're going to connect to our database from inside the container, so we need first to access the container self. We use container's name (which in this case is `wallet_db_1`) to establish connection:

```bash
$ docker exec -it wallet_db_1 bash
```

And run corresponding connection command:

```bash
root@1c109035d7e1:/# mysql -u wallet       
```

**NOTE:** Same instructions apply to access using MySQL root user and password specified in `$MYSQL_ROOT_PASSWD` environment variable.