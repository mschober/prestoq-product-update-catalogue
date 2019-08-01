# Product Update Catalogue Service

> A single threaded blocking queue event system that has services for receiving updates, transforming updates for business rules, and saving updates.

## To run package with maven and run as a jar

1. `mvn clean install && mvn package && ./run.sh`sh

## To feed data to the service

1. drop a file in /tmp/productchanges
2. if /tmp/productchanges doesn't exist

`mkdir /tmp/productchanges`sh

## How it works
> When files land in the change directory they will be automatically pickedup on a 2 second polling mechanism.
> Multiple file changes in a single change interval will all be picked up.
> Raw rows in the file will be fed as individual events through each of the services in the parent runner.
> Each row follows the fixed with format specified in the spec doc.
> The final events have a prefix of: Save Event Data.

