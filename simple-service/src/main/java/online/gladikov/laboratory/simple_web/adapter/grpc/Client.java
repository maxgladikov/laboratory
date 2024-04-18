package online.gladikov.laboratory.simple_web.adapter.grpc;

public class Client {
    @GrpcClient
    HelloWorldServiceGrpc.HelloWorldServiceStub stub;
}
