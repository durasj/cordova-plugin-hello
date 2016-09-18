/*global cordova, module*/

module.exports = {
    markPhoneNumbers: function (text, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Regex", "markPhoneNumbers", [text]);
    }
};
