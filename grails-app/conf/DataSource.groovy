dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "av"
    password = "core"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/avcore"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/avcore"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://mssaserver04.library.yale.edu:3306/avcore"
        }
    }
}
