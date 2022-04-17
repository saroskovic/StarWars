package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Icon;

import java.util.List;

public interface IconService {

    Icon saveIcon(Icon icon);

    Icon getIconById(Long iconId);

    List<Icon> fetchAllIcons();

    Icon updateIcon(Long iconId, Icon icon);

    void deleteIcon(Long iconId);
}
