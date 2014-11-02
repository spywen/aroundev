/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.service.auth', [
    'pascalprecht.translate',
    'restangular',
    'aroundev.service.utils'
])
.config(function(RestangularProvider){
    //RestangularProvider.setBaseUrl('/api/user/');
})
.service('authService',function($translate, $http, $location, Restangular, $q, user, toastr, utilsService){

    this.login = function(login,password){
        return $q(function(resolve, reject){
            Restangular.one('login').customPOST("login="+login+"&password="+password, undefined, undefined, {'Content-Type': 'application/x-www-form-urlencoded'}).then(function(){
                resolve(true);
            },function(){
                reject(false);
            });
        });
    };

    this.logout = function(){
        return $q(function(resolve, reject){
            Restangular.one('logout').get().then(function(){
                window.location.reload();
                resolve(result);
            }, function(){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
                reject(false);
            });
        });
    };

    this.getProfile = function(){
        return $q(function(resolve, reject){
            if(_.isNull(user) || (_.isEmpty(user.roles))){
                Restangular.one('api/user/currentProfil').get().then(function(result){
                    var rolesNames = [];
                    _.forEach(result.roles, function(role){
                        rolesNames.push(role.name);
                    });
                    user = {username: result.login, roles:rolesNames};
                    resolve(result);
                },function(){
                    user = {username: '', roles:[]};
                    reject(false);
                });
            }else{
                resolve(user);
            }
        });
    };

    this.hasRoles = function(roles){
        var that = this;
        return $q(function(resolve, reject){
            if(!_.isNull(user)){
                resolve(utilsService.containMoreThanOne(user.roles, roles));
            }else{
                that.getProfile().then(function(){
                    resolve(utilsService.containMoreThanOne(user.roles, roles));
                },function(){
                    resolve(false);
                });
            }
        });
    };

});