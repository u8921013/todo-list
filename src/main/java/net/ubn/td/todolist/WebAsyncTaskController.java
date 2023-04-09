package net.ubn.td.todolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * WebAsyncTask实现长轮询 * * @author 悟纤「公众号SpringBoot」 * @date 2022-01-14 * @slogan 大道至简 悟在天成
 */
@RestController
public class WebAsyncTaskController {

    @GetMapping("/webAsyncTaskHandle")
    public WebAsyncTask<String> webAsyncTaskHandle() {
        long timeout = 4600;//超时时间
        //       /*            WebAsyncTask构建方法两个参数：timeout和Callable         */
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(timeout, new Callable<String>() {
            //Callable.call();
            @Override
            public String call() throws Exception {
                //    执行耗时的逻辑
                try {                    //休眠n秒钟进行模拟业务代码.
                    TimeUnit.SECONDS.sleep(new Random().nextInt(7));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "love ~ " + new Date();
            }
        });
        //（非必须设置）超时回调处理
        webAsyncTask.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "timeout";
            }
        });
        //(非必须设置)错误回调处理
        webAsyncTask.onError(() -> "error");        //(非必须设置)完成回调
        webAsyncTask.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("complete...");
            }
        });
        return webAsyncTask;
    }
}
