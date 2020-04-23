# springboot-aws-sqs
A simple publisher and consumer using AWS SQS

*Note - Please set your credentials and queue in the yml file.

Publisher - There is a scheduled job which puts a message into the queue every 2 seconds

Listener - Consmer will read the messages from the queue and log to the console.
