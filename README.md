# test_task

simple REST controller to access data stored in H2 database.

example:

## (GET) get Person data by his identity
### http://localhost:8080/users/1 
you will receive:
> {<br>
> &nbsp;&nbsp;"name": "vadim",<br>
> &nbsp;&nbsp;"surname": "storozhuk"<br>
> &nbsp;&nbsp;"age": 21<br>
> }
