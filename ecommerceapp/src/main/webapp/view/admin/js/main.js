$(function() {
    toastr.options = {
        "closeButton": true,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    var loginSuccess = "<c:out value='${loginSuccess}'/>";
    var loginError = "<c:out value='${loginError}'/>";
    var logoutSuccess = "<c:out value='${logoutSuccess}'/>";

    if (loginSuccess === "true") {
        toastr.success('Đăng nhập thành công', 'Thành công');
    }
    if (loginError !== "") {
        toastr.error(loginError, 'Lỗi');
    }
    if (logoutSuccess === "true") {
        toastr.success('Đăng xuất thành công', 'Thông báo');
    }
})