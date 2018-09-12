/* ==========================================================================
Hide ng-cloak on page load, https://docs.angularjs.org/api/ng/directive/ngCloak
========================================================================== */
[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
    display: none !important;
}

/* ==========================================================================
Development Ribbon
========================================================================== */
.ribbon {
    background-color: #a00;
    box-shadow: 0 0 10px #888;
    left: -3.5em;
    moz-box-shadow: 0 0 10px #888;
    moz-transform: rotate(-45deg);
    ms-transform: rotate(-45deg);
    o-transform: rotate(-45deg);
    overflow: hidden;
    position: absolute;
    top: 40px;
    transform: rotate(-45deg);
    webkit-box-shadow: 0 0 10px #888;
    webkit-transform: rotate(-45deg);
    white-space: nowrap;
    width: 15em;
    z-index: 9999;
    pointer-events: none;
}

.ribbon a {
    border: 1px solid #faa;
    color: #fff;
    display: block;
    font: bold 81.25% 'Helvetica Neue', Helvetica, Arial, sans-serif;
    margin: 1px 0;
    padding: 10px 50px;
    text-align: center;
    text-decoration: none;
    text-shadow: 0 0 5px #444;
    pointer-events: none;
}

/* ==========================================================================
Version number in navbar
========================================================================== */
.navbar-version {
    font-size: 10px;
    color: #FFFFFF;
}

/* ==========================================================================
navbar text
========================================================================== */
.navbar-default .navbar-brand {
    color: #444;
}

/* ==========================================================================
Browser Upgrade Prompt
========================================================================== */
.browserupgrade {
    margin: 0.2em 0;
    background: #ccc;
    color: #000;
    padding: 0.2em 0;
}

/* ==========================================================================
Logo styles
========================================================================== */
.navbar-brand.logo {
    padding: 5px 15px;
}

.logo .logo-img {
    height: 45px;
    display: inline-block;
}

/* ==========================================================================
Main page styles
========================================================================== */
.hero-unit {
    margin: 50px auto 0 auto;
    width: 300px;
    font-size: 18px;
    font-weight: 200;
    line-height: 30px;
    background-color: #eee;
    border-radius: 6px;
    padding: 60px;
}

.hero-unit h1 {
    font-size: 60px;
    line-height: 1;
    letter-spacing: -1px;
}

.hipster {
    display: inline-block;
    width: 100%;
    height: 332px;
    background: url("../images/bg-ok.svg") no-repeat center top;
    background-size: contain;
    margin-top: 10px;
}

/* wait autoprefixer update to allow simple generation of high pixel density media query */
@media
only screen and (-webkit-min-device-pixel-ratio: 2),
only screen and (   min--moz-device-pixel-ratio: 2),
only screen and (     -o-min-device-pixel-ratio: 2/1),
only screen and (        min-device-pixel-ratio: 2),
only screen and (                min-resolution: 192dpi),
only screen and (                min-resolution: 2dppx) {
    .hipster {
        background: url("../images/bg-ok.svg") no-repeat center top;
        background-size: contain;
    }
}

/* ==========================================================================
Generic styles
========================================================================== */
.error {
    color: white;
    background-color: red;
}

.pad {
    padding: 10px;
}

.break {
    white-space: normal;
    word-break:break-all;
}

.voffset  { margin-top: 2px; }
.voffset1 { margin-top: 5px; }
.voffset2 { margin-top: 10px; }
.voffset3 { margin-top: 15px; }
.voffset4 { margin-top: 30px; }
.voffset5 { margin-top: 40px; }
.voffset6 { margin-top: 60px; }
.voffset7 { margin-top: 80px; }
.voffset8 { margin-top: 100px; }
.voffset9 { margin-top: 150px; }

.readonly {
    background-color: #eee;
    opacity: 1;
}

/* ==========================================================================
make sure browsers use the pointer cursor for anchors, even with no href
========================================================================== */
a {
    color: #105E90;
    background-color: transparent;
}

a:hover, .hand, [jh-sort-by] {
    cursor: pointer;
}

/* ==========================================================================
Metrics and Health styles
========================================================================== */
#threadDump .popover, #healthCheck .popover {
    top: inherit;
    display: block;
    font-size: 10px;
    max-width: 1024px;
}

#healthCheck .popover {
    margin-left: -50px;
}

.health-details {
    min-width: 400px;
}

/* ==========================================================================
start Password strength bar style
========================================================================== */
ul#strengthBar {
    display:inline;
    list-style:none;
    margin:0;
    margin-left:15px;
    padding:0;
    vertical-align:2px;
}

.point:last {
    margin:0 !important;
}
.point {
    background:#DDD;
    border-radius:2px;
    display:inline-block;
    height:5px;
    margin-right:1px;
    width:20px;
}

/* ==========================================================================
Custom alerts for notification
========================================================================== */
.alerts .alert{
    text-overflow: ellipsis;
}
.alert pre{
    background: none;
    border: none;
    font: inherit;
    color: inherit;
    padding: 0;
    margin: 0;
}

.alert .popover pre {
    font-size: 10px;
}

.alerts .toast {
    position: fixed;
    width: 100%;
}

.alerts .toast.left {
    left: 5px;
}

.alerts .toast.right {
    right: 5px;
}

.alerts .toast.top {
    top: 55px;
}

.alerts .toast.bottom {
    bottom: 55px;
}

@media screen and (min-width: 480px) {
    .alerts .toast {
        width: 50%;
    }
}

/* ==========================================================================
entity tables helpers
========================================================================== */
/* Remove Bootstrap padding from the element
   http://stackoverflow.com/questions/19562903/remove-padding-from-columns-in-bootstrap-3 */
.no-padding-left { padding-left: 0 !important; }
.no-padding-right { padding-right: 0 !important; }
.no-padding-top { padding-top: 0 !important; }
.no-padding-bottom { padding-bottom: 0 !important; }
.no-padding { padding: 0 !important; }

/* bootstrap 3 input-group 100% width
   http://stackoverflow.com/questions/23436430/bootstrap-3-input-group-100-width */
.width-min { width: 1% !important; }

/* Makes toolbar not wrap on smaller screens
 http://www.sketchingwithcss.com/samplechapter/cheatsheet.html#right */
.flex-btn-group-container {
   display: -webkit-flex;
   display: flex;
   -webkit-flex-direction: row;
   flex-direction: row;
   -webkit-justify-content: flex-end;
   justify-content: flex-end;
}

.jh-table > tbody > tr > td {
    /* Align text in td vertically (top aligned by Bootstrap) */
    vertical-align: middle;
}

.jh-table > thead > tr > th > .glyphicon-sort, .jh-table > thead > tr > th > .glyphicon-sort-by-attributes, .jh-table > thead > tr > th > .glyphicon-sort-by-attributes-alt {
    /* less visible sorting icons */
    opacity: 0.5;
}

.jh-table > thead > tr > th > .glyphicon-sort:hover, .jh-table > thead > tr > th > .glyphicon-sort-by-attributes:hover, .jh-table > thead > tr > th > .glyphicon-sort-by-attributes-alt:hover {
    /* full visible sorting icons and pointer when mouse is over them */
    opacity: 1;
    cursor: pointer;
}

/* ==========================================================================
entity detail page css
========================================================================== */
.dl-horizontal.jh-entity-details > dd {
    margin-bottom: 15px;
}

@media screen and (min-width: 768px) {
    .dl-horizontal.jh-entity-details > dt {
        margin-bottom: 15px;
    }

    .dl-horizontal.jh-entity-details > dd {
        border-bottom: 1px solid #eee;
        padding-left: 180px;
        margin-left: 0;
    }
}

/* ==========================================================================
ui bootstrap tweaks
========================================================================== */
.nav, .pagination, .carousel, .panel-title a {
    cursor: pointer;
}


.datetime-picker-dropdown > li.date-picker-menu div > table .btn-default,
.uib-datepicker-popup  > li > div.uib-datepicker > table .btn-default {
    border: 0;
}

.datetime-picker-dropdown > li.date-picker-menu div > table:focus,
.uib-datepicker-popup  > li > div.uib-datepicker > table:focus {
    outline: none;
}

/* jhipster-needle-css-add-main JHipster will add new css style */
.breadcrumKukul {
    padding:  60px 0 0 0;
}
.pagination>li>a, .pagination>li>span{
    position: inherit;
}
hr.black {
    overflow: initial !important;
}
hr.black:before {
    content: " ";
}
hr.black:before {
    width: 35px !important;
    height: 5px !important;
    background-color: #272829 !important;
    position: absolute !important;
}
.main-footer {
    margin-top: 20px;
}

li.submenuLine{
    border-left: solid 1px #666;
    margin-top: 10px;
}
