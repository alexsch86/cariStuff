

let test = [3, 4, 5].map(x => x * x);

console.log('Test is ' + test);

let my_http = $http;

let dummy_entity = my_http.get("dummyEntity/getDummy/?id=" + 2)
    .success(dummy => {
        this.dummyEntity = dummy;
    });