package dev.kofemann.palyground.zk;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorReconnectPolicy {

    public static void main(String[] args) throws InterruptedException {


        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1_000, 10);
        CuratorFramework curator = CuratorFrameworkFactory.newClient("zk-lab-1:2181",
                                                 20_000, 15_000,
                                                 retryPolicy);

        curator.start();
        curator.getZookeeperClient().blockUntilConnectedOrTimedOut();

    }

}
