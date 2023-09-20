# Getting Started with App Demo Backend


## Available Scripts

Pull Microsoft SQL server docker image:

### `docker pull mcr.microsoft.com/azure-sql-edge `


Run and start SQL server docker component to connect database:

Using the resource/init_db.sql to init database

### `sudo docker run --cap-add SYS_PTRACE -e 'ACCEPT_EULA=1' -e 'MSSQL_SA_PASSWORD=Pwd@12345' -p 1433:1433 --name sqledge -d mcr.microsoft.com/azure-sql-edge`




Build and start app:

App will start with port 5001

localhost:5001/api

### `mvn spring-boot:run `


