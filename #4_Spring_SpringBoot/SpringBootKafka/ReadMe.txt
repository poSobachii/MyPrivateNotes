// brew kafka

kafka-topics --version 					// to check kafka-topics version, same for all others
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties				// to start zookeeper server port 2181
kafka-server-start /usr/local/etc/kafka/server.properties						// to start kafka server port 9092

kafka-topics --create --topic test --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1     // to start topic "test"
kafka-topics --delete --topic test --bootstrap-server localhost:9092            // to delete topic
kafka-topics --list --bootstrap-server localhost:9092                           // to list available topics

kafka-console-producer --broker-list localhost:9092 --topic test                // create broker for topic "test"
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning      // to create consumer for topic "test"

============================================================================================================================================

// need to dwnl kafka from apache site
// inside kafka folder write commands

bin/zookeeper-server-start.sh config/zookeeper.properties					// to start zookeeper 2181
bin/kafka-server-start.sh config/server.properties							// to start server 9092
bin/kafka-topics.sh --create --topic test --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1	// create topic "test"
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test		// to create broker for topic "test"
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning			// to create consumer for topic "test"

============================================================================================================================================

connect-distributed.sh
connect-mirror-maker.sh
connect-standalone.sh
kafka-acls.sh
kafka-broker-api-versions.sh
kafka-cluster.sh
kafka-configs.sh
kafka-console-consumer.sh
kafka-console-producer.sh
kafka-consumer-groups.sh
kafka-consumer-perf-test.sh
kafka-delegation-tokens.sh
kafka-delete-records.sh
kafka-dump-log.sh
kafka-features.sh
kafka-get-offsets.sh
kafka-leader-election.sh
kafka-log-dirs.sh
kafka-metadata-shell.sh
kafka-mirror-maker.sh
kafka-producer-perf-test.sh
kafka-reassign-partitions.sh
kafka-replica-verification.sh
kafka-run-class.sh
kafka-server-start.sh
kafka-server-stop.sh
kafka-storage.sh
kafka-streams-application-reset.sh
kafka-topics.sh
kafka-transactions.sh
kafka-verifiable-consumer.sh
kafka-verifiable-producer.sh
trogdor.sh
zookeeper-security-migration.sh
zookeeper-server-start.sh
zookeeper-server-stop.sh
zookeeper-shell.sh