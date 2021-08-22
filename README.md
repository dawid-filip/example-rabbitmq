### The example-rabbitmq
Simple example of RabbitMQ implementation.
After application start-up it will send up 2 messages on the queue and then application will pull and read sent messaged. This will recur every 10 seconds.

# RabbitMQ: version
Tested with ``rabbitmq-3.9.4`` which is available on: [https://www.rabbitmq.com/install-windows.html#installer](https://www.rabbitmq.com/install-windows.html#installer)

# RabbitMQ server: execution
Download:
1. The rabbitmq-server [https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.9.4/rabbitmq-server-3.9.4.exe](https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.9.4/rabbitmq-server-3.9.4.exe), and
2. The Erlang [https://erlang.org/download/otp_win64_24.0.exe](https://erlang.org/download/otp_win64_24.0.exe).

Run as Administrator and install:
1. The `otp_win64_24.0.exe` and then,
2. The `rabbitmq-server-3.9.4.exe`.

Then add system environment variables:
- `ERLANG_HOME` - should point to Erlang installation directory (i.e: C:\Program Files\erl-24.0),
- `RABBITMQ_BASE` - should point to RabbitMQ installation directory (i.e: C:\Program Files\rabbitmq_server-3.9.4).

Open command shell as Administrator and navigate to rabbitmq-server directory and execute following commands:
1. `cd rabbitmq_server-3.9.4\sbin`
2. `rabbitmq-plugins.bat enable rabbitmq_management`
3. `rabbitmq-server.bat start`

After a few seconds server will be ready to use.

Open rabbitmq administration panel by running [http://localhost:15672/](http://localhost:15672/) URL in your web browser and login with following (default) user credentials:
- Username: `guest` *
- Password: `guest` *

`*` you can change default credentials be updating corresponding properties in the `application.properties` file.
