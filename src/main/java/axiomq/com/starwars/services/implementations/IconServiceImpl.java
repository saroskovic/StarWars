package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Icon;
import axiomq.com.starwars.repositories.IconRepository;
import axiomq.com.starwars.services.IconService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IconServiceImpl implements IconService {

    private final IconRepository iconRepository;

    @Override
    public Icon saveIcon(Icon icon) {
        return iconRepository.save(icon);
    }

    @Override
    public Icon getIconById(Long iconId) {
        return iconRepository.findById(iconId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Icon: %d not found", iconId)));
    }

    @Override
    public List<Icon> fetchAllIcons() {
        return iconRepository.findAll();
    }

    @Override
    public Icon updateIcon(Long iconId, Icon newIcon) {
        Icon icon = getIconById(iconId);
        if(newIcon.getIconName() != null)
            icon.setIconName(newIcon.getIconName());
        if(newIcon.getPath() != null)
            icon.setPath(newIcon.getPath());
        return null;
    }

    @Override
    public void deleteIcon(Long iconId) {
        Icon icon = getIconById(iconId);
        iconRepository.delete(icon);

    }
}
