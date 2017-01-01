package com.jgabrielfreitas.alfred;

/**
 * Created by JGabrielFreitas on 31/12/16.
 */

public abstract class Provider<T> {

    protected Receiver<T> receiver;
    protected T data;

    public Provider(Receiver<T> receiver) {
        this.receiver = receiver;
        init();
    }

    protected void updateData(T diffResult){}

    protected abstract T recoverData();

    protected void init() {}

    /**
     * For each provider, a new rule to check if is necessary update or not need to be created.
     * The use cases for each provider will be declared here.
     */
    protected abstract boolean isNecessaryUpdate();

    /**
     * Receive the older data and newest data to check difference.
     * After that, call onReceiveData() from Receiver
     *
     * @param older  Older data from application, for instance the local data.
     * @param newest Newest data, for instance the API
     */
    protected abstract void diff(T older, T newest);

}
