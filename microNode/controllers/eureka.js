const eureka = require('eureka-js-client').Eureka;
const eurekaHost = (process.env.EUREKA_DEFAULTZONE ||'DiscoveryServer');
const eurekaPort = (process.env.EUREKA_PORT || 8761);
const hostName = (process.env.HOSTNAME || 'localhost');
const ipAddr = '127.0.0.1';
exports.registerWithEureka = function( PORT) {
  const client = new eureka({
    instance: {
      app: hostName,
      hostName: hostName,
      instanceId: hostName,
      ipAddr: ipAddr,
      port: {
        $: PORT,
        '@enabled': 'true',
      },
      vipAddress: hostName,
      statusPageUrl: 'http://localhost:4000/employees',
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },

    },
    eureka: {
      host:eurekaHost, // Nom du service Docker Compose pour Eureka
      port: eurekaPort,
      servicePath: '/eureka/apps/',
      maxRetries: 5,
      requestRetryDelay: 2000,
    },
    
  });

  client.logger.level('debug');
  client.start( error => {
    console.log(error || "user service registered")
});





client.on('deregistered', () => {
    process.exit();
 
})

client.on('started', () => {
  console.log("eureka host  " + eurekaHost);
})
};
