package SpringMVC.repository;

import SpringMVC.entity.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileModel,Long> {
}
