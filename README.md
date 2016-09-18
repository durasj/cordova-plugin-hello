# Cordova Plugin Test Regex

Simple test plugin that does some specific matching/replacing in Java. Currently only marks phone numbers - or basically any group of numbers looking like phone number.

## Using
    
Install the plugin

    $ cordova plugin add https://github.com/durasj/cordova-plugin-test-regex

```js
    var success = function(contactString) {
        // Will be "Name Surname, **S**+400 900 123 456**E**, **S**0945 456 789**E**"
        alert(contactString);
    }

    var failure = function(error) {
        alert("Error calling Plugin", error);
    }

    regex.markPhoneNumbers("Name Surname, +400 900 123 456, 0945 456 789", success, failure);
```
