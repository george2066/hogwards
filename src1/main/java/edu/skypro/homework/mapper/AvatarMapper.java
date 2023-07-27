package edu.skypro.homework.mapper;

import edu.skypro.homework.controller.AvatarController;
import edu.skypro.homework.dto.AvatarDto;
import edu.skypro.homework.exception.StudentNotFoundException;
import edu.skypro.homework.model.Avatar;
import edu.skypro.homework.repository.AvatarRepository;
import edu.skypro.homework.repository.StudentRepository;
import edu.skypro.homework.service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AvatarMapper {
    private final AvatarRepository avatarRepository;
    private final InfoService infoService;

    public AvatarDto toDto(Avatar avatar) {
        return AvatarDto.builder()
                .id(avatar.getId())
                .avatarUrl(
                        UriComponentsBuilder.newInstance()
                                .scheme("http")
                                .host("localhost")
                                .port(infoService.getPort())
                                .pathSegment(AvatarController.BASE_PATH, String.valueOf(avatar.getStudent().getId()))
                                .toUriString()
                )
                .fileSize(avatar.getFileSize())
                .mediaType(avatar.getMediaType())
                .studentId(avatarRepository.studentId(avatar.getId()))
                .build();
    }

}
