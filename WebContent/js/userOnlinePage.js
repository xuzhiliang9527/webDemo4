	$(document).ready(function() {
			$(".delete").click(function() {
				$(this).parent().hide();
                });
            $("#button_show_info").click(function() {
                $("#showinfo").slideToggle("slow", function() {
                });
            });
            showCurrentTime();
            var currentTime = 1;
            function showCurrentTime() {
                setInterval(function() {
                    $("#showCurrentTime").html("在线时间：" + currentTime + "s");
                    currentTime++;
                }, 1000)
            }
	});
