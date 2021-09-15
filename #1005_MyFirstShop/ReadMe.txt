if MySQL is faulting with time zone error run these statements in sql bench :
SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';


https://mailtrap.io/