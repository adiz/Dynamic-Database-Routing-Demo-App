Dynamic-Database-Routing-Demo-App
=================================

Based on AbstractRoutingDataSource from Spring JDBC, 2 configured datasources are intermittently selected for queries depending on the parity of the minute when the queries are executed.

The databases are configured through Liquibase and reside in memory (H2). 
The first one is populated at spring context boot, through a SpringLiquibase bean.
The second one has its content created and removed dynamically, through a CustomLiquibase bean that extends SpringLiquibase.

The concepts are proven by unit tests.