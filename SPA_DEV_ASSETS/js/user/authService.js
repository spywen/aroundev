/**
 * Created by laurent on 19/10/2014.
 */
aroundevApp.service('authService',function($translate, $http, $location){

    this.login = function(login,password){
        var data = "login="+login+"&password="+password;
        $http.post('login', data, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).
        success(function(data, status, headers, config) {
            $location.path('/');
            window.location.reload();
        }).
        error(function(data, status, headers, config){
            toastr.error($translate.instant('LOGIN_LOG_IN_FAILED'));
        });
    };

    this.logout = function(){
        $http.get('logout')
            .success(function(data, status, headers, config){
                window.location.reload();
            }).error(function(data, status, headers, config){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
            });
    };

});