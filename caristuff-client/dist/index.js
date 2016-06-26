"use strict";

var test = [3, 4, 5].map(function (x) {
    return x * x;
});

console.log('Test is ' + test);

var my_http = $http;

var dummy_entity = my_http.get("dummyEntity/getDummy/?id=" + 2).success(function (dummy) {
    undefined.dummyEntity = dummy;
});