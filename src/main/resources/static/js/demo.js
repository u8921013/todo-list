    let doPOST=function(url,param){
          return new Promise(function (resolve, reject) {
                $.ajax({url,contentType:"application/json; charset=utf-8",type: "POST",dataType: 'json',data:JSON.stringify(param)
                }).then(function (data) {
                    resolve(data);
                }, function (err) {
                    reject(err);
                });
          });
    }
    let doGET = function (url) {
          return new Promise(function (resolve, reject) {
          $.ajax({
            url,
            contentType: "application/json; charset=utf-8",
            type: "GET",
            dataType: "json",
            xhrFields: {
                  withCredentials: true
             }
          }).then(
            function (data) {
              resolve(data);
            },
            function (err) {
              reject(err);
            }
          );
        });
    };

    let getURLQueryParams = function () {
            var params = {};
            var query = window.location.search;
            if (query && query.length) {
                query = query.substring(1);
                var keyParams = query.split('&');
                for (var x = 0; x < keyParams.length; x++) {
                    var keyVal = keyParams[x].split('=');
                    if (keyVal.length > 1) {
                        params[keyVal[0]] = decodeURIComponent(keyVal[1]);
                    }
                }
            }
            return params;
        }