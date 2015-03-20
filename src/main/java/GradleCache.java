import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by mcorrea on 3/20/15.
 */
public class GradleCache {
    
    public static void main(String args[])throws Exception{


        Cache<String, String> tokens = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .weakKeys()
                .build();
        
        tokens.put("123", "456");

        System.out.println(tokens);

        System.out.println(tokens.getIfPresent("123"));
        
        Thread.sleep(6000);

        System.out.println(tokens.getIfPresent("123"));
    }
    
}
