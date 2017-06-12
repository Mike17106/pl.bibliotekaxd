function UserLoginService() {
    this.isUserLoggedIn = false;
    this.credentials = {
        username: '',
        password: ''
    };

    this.isLoggedIn = function () {
        return this.isUserLoggedIn;
    };

    this.logIn = function (credentials) {
        var self = this;
        $.ajax('page/login', credentials).then(  //Endpoint do logowania
            function (response) {
            self.setCredentials(credentials);
            },
            function (error) {

            }
        );
    };

    this.logOut = function () {
        $.ajax('page/logout').then(
            function () {
                this.clearUserCredentials();
            },
            function () {

            }
        )
    };

    this.setCredentials = function (credentials) {
        this.credentials.username = credentials.username;
        this.credentials.password = credentials.password;
        this.setLocalStorageCredentials(credentials);
    };

    this.clearUserCredentials = function () {
        this.credentials = {
            username: '',
            password: ''
        };
        this.clearUserLocalStorageCredentials();
    };

    this.getLocalStorageCredentials = function () {
        return LoclStoarge.get('UserCredentials');
        //this.localStorageCredentials = LocalStorage; // znaleźć wywołanie localStorage'a albo cookies
    };

    this.clearUserLocalStorageCredentials = function(){
      localStorage.delete('UserCredentials');
    };

    this.setLocalStorageCredentials = function (credentials) {
        LocalStorage.set('UserCrednetials', credentials)
    }
}

var userLoginService = new UserLoginService();