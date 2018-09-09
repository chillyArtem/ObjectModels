package Tours.Type_of_tour;

import Tours.Enums.Countries;
import Tours.Enums.Transport;
import Tours.Enums.TypeOfFeed;
import Tours.Interfaces.Feedable;

public class Sightseeing_tour extends Tour implements Feedable {

    private Countries country;
    private int desiredNumberOfDays;
    private Transport transport;
    private TypeOfFeed feed;

    public Sightseeing_tour(Countries county) {
        this.country = county;
    }

    public Sightseeing_tour(Countries county, int desiredNumberOfDays) {
        this(county);
        this.desiredNumberOfDays = desiredNumberOfDays;
    }

    public Sightseeing_tour(Countries county, int desiredNumberOfDays, Transport transport) {
        this(county, desiredNumberOfDays);
        this.transport = transport;
    }

    public Sightseeing_tour(Countries county, int desiredNumberOfDays, Transport transport, TypeOfFeed feed) {
        this(county, desiredNumberOfDays, transport);
        this.feed = feed;
    }


    @Override
    public int calculateOverallPrice() {
        switch (country) {
            case RUSSIA:
                return (transport == Transport.PLANE) ? 3500 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 2100 * desiredNumberOfDays
                        : 1880 * desiredNumberOfDays;
            case ITALIA:
                return (transport == Transport.PLANE) ? 5500 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 4100 * desiredNumberOfDays
                        : 2280 * desiredNumberOfDays;
            case FRANCE:
                return (transport == Transport.PLANE) ? 5600 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 2500 * desiredNumberOfDays
                        : 1180 * desiredNumberOfDays;
            case GERMANY:
                return (transport == Transport.PLANE) ? 3900 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 1900 * desiredNumberOfDays
                        : 1500 * desiredNumberOfDays;
            case FINLAND:
                return (transport == Transport.PLANE) ? 6500 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 3200 * desiredNumberOfDays
                        : 2300 * desiredNumberOfDays;
            case ESTONIA:
                return (transport == Transport.PLANE) ? 4500 * desiredNumberOfDays
                        : (transport == Transport.TRAIN) ? 2200 * desiredNumberOfDays
                        : 2000 * desiredNumberOfDays;
        }
        return 0;
    }

    @Override
    public void applyCredit() {

    }

    @Override
    public int provideFeed() {
        switch (feed) {
            case BB:
                return calculateOverallPrice() + 2000 * desiredNumberOfDays;
            case BO:
                return calculateOverallPrice() + 1000 * desiredNumberOfDays;
            case AI:
                return calculateOverallPrice() + 4000 * desiredNumberOfDays;
            default:
                return 0;
        }
    }
}
