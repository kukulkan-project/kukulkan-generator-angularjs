{
    "reset": {
        "request": {
            "title": "Reset your password",
            "form": {
                "button": "Reset password"
            },
            "messages": {
                "info": "Enter the email address you used to register",
                "success": "Check your emails for details on how to reset your password.",
                "notfound": "<strong>Email address isn't registered!</strong> Please check and try again"
            }
        },
        "finish" : {
            "title": "Reset password",
            "form": {
                "button": "Validate new password"
            },
            "messages": {
                "info": "Choose a new password",
                "success": "<strong>Your password has been reset.</strong> Please <a class=\"alert-link\" href=\"\" ng-click=\"vm.login()\">sign in</a>.",
                "keymissing": "The reset key is missing.",
                "error": "Your password couldn't be reset. Remember a password request is only valid for 24 hours."
            }
        }
    }
}
