<!doctype html>
<html class="no-js" lang="es" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${project.id}</title>
    <meta name="description" content="">
    <meta name="google" content="notranslate">
    <meta name="theme-color" content="#000000">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css content/css/vendor.css -->
    <!-- bower:css -->
    <!-- endinject -->
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="manifest" href="manifest.webapp" />
    <link href="https://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
    <link rel="stylesheet" href="content/css/main.css">
</head>

<body data-ng-app="${project.id}App" data-ng-strict-di>
    <!--[if lt IE 9]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <page-ribbon></page-ribbon>
    <!-- Contenido -->
    <main class="page">
        <div data-ui-view="navbar" data-ng-cloak></div>
        <div class="container">
            <div data-ncy-breadcrumb></div>
            <div data-ui-view="content"></div>
            <!-- Angular views -->
        </div>
        <noscript>
            <h1>You must enable javascript to view this page.</h1>
        </noscript>
    </main>

    <!-- uncomment this for adding service worker
        <script>
            if ('serviceWorker' in navigator) {
                 navigator.serviceWorker
                    .register('./sw.js')
                    .then(function() { console.log('Service Worker Registered'); });
            }
        </script>
    -->
    <!-- Google Analytics: uncomment and change UA-XXXXX-X to be your site's ID.
    <script>
        (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
        function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
        e=o.createElement(i);r=o.getElementsByTagName(i)[0];
        e.src='//www.google-analytics.com/analytics.js';
        r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
        ga('create','UA-XXXXX-X');ga('send','pageview');
    </script>-->

    <!-- build:js app/vendor.js -->


    <!-- bower:js -->
    <!-- endinject -->
    <!-- endbuild -->

    <!-- build:js app/app.js  -->
    <!-- inject:js -->
    <!-- endinject -->
    <!-- endbuild -->

    <script src="https://framework-gb.cdn.gob.mx/gobmx.js"></script>
    <script src="https://framework-gb.cdn.gob.mx/assets/scripts/jquery-ui-datepicker.js"></script>
</body>

</html>
