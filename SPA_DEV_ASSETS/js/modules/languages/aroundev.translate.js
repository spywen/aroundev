/**
 * Created by laurent on 18/10/2014.
 */
angular.module('aroundev.translate', [
    'aroundev.service.auth',
    'pascalprecht.translate',
    'ngCookies'
])
.config(function($translateProvider){
    //Translate
    $translateProvider.useStaticFilesLoader({
        prefix: '/app/js/modules/languages/json/',
        suffix: '.json'
    });
    $translateProvider.useCookieStorage();
    $translateProvider.preferredLanguage('en');
})
.controller('translateCtrl', function($scope, $translate, $cookies, configs) {

    /*Enabled or disabled the translate feature*/
    $scope.translateAllowed = configs.translateAllowed;
    //By default english language : Remark -> need to reload page 2x to take in account the default language
    if(!configs.translateAllowed){
        $cookies.NG_TRANSLATE_LANG_KEY = configs.defaultLanguage;
    }

    $scope.en = false;
    $scope.fr = false;

    var currentLanguage = $cookies.NG_TRANSLATE_LANG_KEY;
    if(currentLanguage === '"en"'){
        $scope.en = true;
    }else if(currentLanguage === '"fr"'){
        $scope.fr = true;
    }else{
        $scope.en = true;
    }

    $scope.changeLanguage = function (langKey){
        $translate.use(langKey);
        $scope.en = false;
        $scope.fr = false;
        if(langKey === 'en'){
            $scope.en = true;
        }else if(langKey === 'fr'){
            $scope.fr = true;
        }else{
            $scope.en = true;
        }
    };
});