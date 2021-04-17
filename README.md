# Reservations

Welcome! this is a small, spring-boot powered webapp, written for an NFQ technical assignment.

## Deployment for development

Here's how to deploy this webapp for local development/inspection.

1. Clone this repository
2. Setup a PostgreSQL database
3. Create a copy of the `envConf.sh` file and modify the variables inside so that they contain your PostgreSQL URL, database username and your database user's password.
4. In a command prompt, `source` the copied/modified `envConf.sh` file
5. Run `mvn spring-boot:run` in the root of this project (in the same command prompt as step 4).

## Usage

* The root page contains a link that leads to the login prompt and a link to add a reservation.
* The display board can be accessed by logging in and then going to `/board`.
* The specialist appointment view page can be accessed by going to `/home` (this is also the default path after logging in)

## Project structure

* An SQL dump of the database can be found in `/misc`
* All templates can be found in `/src/main/resources/templates`
* All static assets (javascript, css, icons) can be found in `/src/main/resources/static`
* The rest of the java code is found in `/src/main/java/ml/kelp/nfq/assignment/main`, **all directories below are relative to this directory**
* `/entity` contains all of the database-mapped beans.
* `/controller` contains all of the request handling code.
* `/repository` contains the repositories, which are used to retrieve entity objects from the database
* `/service` contains logical components, which are used to perform calculations in various places in the app
* `/configuration` contains the classes which are used to configure various aspects of the spring-boot framework when starting