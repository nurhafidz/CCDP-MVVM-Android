package ac.id.unikom.challenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final Meter model;
    private final MutableLiveData<String> kilometer;
    private final MutableLiveData<String> centimeter;

    public MainViewModel() {
        model = Meter.getInstance();
        kilometer = new MutableLiveData<>();
        centimeter = new MutableLiveData<>();
    }

    public LiveData<String> getKilometer() {
        return kilometer;
    }

    public LiveData<String> getCentimeter() {
        return centimeter;
    }

    public void setMeter(double meter) {
        model.setMeter(meter);
        updateConversions();
    }

    private void updateConversions() {
        kilometer.postValue(model.toKilometer());
        centimeter.postValue(model.toCentimeter());
    }
}
