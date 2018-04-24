$(function() {
    $(".status").on("change", function() {
        var me = $(this);
        console.log(me);
        var orderId = me.attr("order-id");
        var request = {
          newStatus: me.val()
        };
        $.ajax({
            url: "/" + orderId + "/update-status",
            type: 'post',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(request),
            success: function () {
                location.reload();
            }
        });
    });
}());